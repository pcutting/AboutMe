package com.nevie.aboutme

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NewHobbyFragment : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        // https://developer.android.com/guide/topics/ui/dialogs
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            //var view : View = layoutInflater.inflate(R.layout.fragment_new_hobby,null)
            //var activity_editview = view.context. findViewById<EditText(R.id.hobby_edit_text)


            builder.setView(inflater.inflate(R.layout.fragment_new_hobby,null))
            //builder.setMessage(R.string.new_fragment_message)

                .setPositiveButton(R.string.save_button,
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.d("DialogFragment", "Save clicked, $dialog, $id")
                    })
                .setNegativeButton(R.string.cancel_button,
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.d("DialogFragment", "Save clicked, $dialog, $id")
                    })
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}