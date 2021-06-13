package com.acash.workshopedia.fragments.mainscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.acash.workshopedia.R
import com.acash.workshopedia.adapters.APPLIED_WORKSHOPS_IDS
import com.acash.workshopedia.adapters.WorkshopAdapter
import com.acash.workshopedia.database.DbHelper
import com.acash.workshopedia.database.WorkshopTable
import com.acash.workshopedia.fragments.auth.USER_NAME
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_student_dashboard.*
import kotlinx.android.synthetic.main.fragment_workshops_container.*

class StudentDashboardFragment : Fragment() {

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = DbHelper(requireContext()).writableDatabase

        val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val userName = prefs.getString(auth.uid.toString() + USER_NAME, "Anonymous")

        val appliedWorkshops =
            prefs.getStringSet(auth.uid.toString() + APPLIED_WORKSHOPS_IDS, HashSet<String>())
                ?.let {
                    WorkshopTable.getAppliedWorkShops(
                        db,
                        it
                    )
                } ?: ArrayList()

        tvUserName.text = requireContext().getString(R.string.welcome, userName)
        tvAppliedCount.text = appliedWorkshops.size.toString()

        rvAppliedWorkshops.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, true)
            adapter =
                WorkshopAdapter(requireActivity(), this@StudentDashboardFragment, appliedWorkshops)
            scrollToPosition(appliedWorkshops.size - 1)
        }
    }
}