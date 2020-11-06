package com.ukcrimebrowser.android.presentation.crime

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.ukcrimebrowser.android.R
import com.ukcrimebrowser.android.di.Injector.inject
import com.ukcrimebrowser.android.domain.adapters.MapAdapter
import com.ukcrimebrowser.android.presentation.crime.detail.CrimeDetailDialogFragment
import com.ukcrimebrowser.android.presentation.map.CrimeMapFragment
import com.ukcrimebrowser.android.presentation.view.TouchableWrapper
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CrimeMapActivity : AppCompatActivity(), CrimeMapContract.View, MapAdapter.MapListener, TouchableWrapper.UpdateMapAfterUserInteraction, DatePickerDialog.OnDateSetListener  {

    companion object {
        private var TAG = CrimeMapActivity::class.java.simpleName
    }

    @Inject
    lateinit var presenter: CrimeMapContract.ActionListener

    @Inject
    lateinit var mapAdapter: MapAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(this)
        setContentView(R.layout.activity_main)

        presenter.setView(this)
        presenter.start()
        mapAdapter.setMapView(map_fragment as CrimeMapFragment)
        mapAdapter.setOnLocationChangedListener(this)
        setup()
    }

    private fun setup() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, 7)

        et_date.setOnClickListener {
            DatePickerDialog(this, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        updateDisplayDate(calendar.time)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        updateDisplayDate(calendar.time)
    }

    private fun updateDisplayDate(date: Date){
        val sdf = SimpleDateFormat(getString(R.string.date_format), Locale.US)
        val dateStr = sdf.format(date.time)
        et_date.setText(dateStr)

        presenter.updateDate(et_date.text.toString())
    }

    override fun onPause() {
        presenter.pause()
        super.onPause()
    }

    override fun onResume() {
        presenter.resume()
        super.onResume()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun onUpdateMapAfterUserInteraction() {
        mapAdapter.requestLocationUpdate()
    }

    override fun onMarkerSelected(crimeDetail: CrimeDetail) {
        val fragment = CrimeDetailDialogFragment.newInstance(crimeDetail)
        fragment.show(supportFragmentManager, TAG)
    }

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        presenter.getCrimes(et_date.text.toString(), latitude, longitude)
    }


    override fun showCrimes(crimeDetails: List<CrimeDetail>, reset: Boolean) {
        mapAdapter.markCrimes(crimeDetails, reset)
    }
}