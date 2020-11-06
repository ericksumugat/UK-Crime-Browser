package com.ukcrimebrowser.android.presentation.crime.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ukcrimebrowser.android.R
import com.ukcrimebrowser.android.presentation.crime.CrimeDetail
import kotlinx.android.synthetic.main.crime_detail_fragment_layout.*

class CrimeDetailDialogFragment: DialogFragment() {

    companion object {

        private const val CRIME_DETAIL = "crimeDetail"

        @JvmStatic
        fun newInstance(crimeDetail: CrimeDetail): CrimeDetailDialogFragment {
            val fragment = CrimeDetailDialogFragment()
            val arguments = Bundle()
            arguments.putParcelable(CRIME_DETAIL, crimeDetail)
            fragment.arguments = arguments
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.crime_detail_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val crimeDetail = arguments?.getParcelable<CrimeDetail>(CRIME_DETAIL)

        crimeDetail?.let {
            tv_category.text = String.format(getString(R.string.label_category), it.category)
            tv_month.text = String.format(getString(R.string.label_month), it.month)
            tv_street.text = String.format(getString(R.string.label_street), it.streetName)
            tv_outcome.text = String.format(getString(R.string.label_outcome), it.outcomeStatus ?: "N/A")
            tv_outcome_date.text = String.format(getString(R.string.label_outcome_date), it.outcomeDate ?: "N/A")
        }
    }
}