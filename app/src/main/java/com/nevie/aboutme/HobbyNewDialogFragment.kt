package com.nevie.aboutme

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.nevie.aboutme.models.Hobby
import com.nevie.aboutme.repositories.HobbyRepository
import java.lang.ClassCastException

class HobbyNewDialogFragment : DialogFragment(){
    internal lateinit var listener: HobbyDialogListener

    interface HobbyDialogListener {
        fun onDialogPositiveClick(dialog: DialogFragment)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as HobbyDialogListener

        } catch (e: ClassCastException) {
            Log.d("HobbyNewDialogFragment",  ClassCastException((context.toString() + "must implement HobbyDialogListener. Error!")).toString())
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        // https://developer.android.com/guide/topics/ui/dialogs
        //https://code.luasoftware.com/tutorials/android/android-text-input-dialog-with-inflated-view-kotlin/
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.fragment_new_hobby,null))
                //builder.setMessage(R.string.new_fragment_message)

                .setPositiveButton(R.string.save_button,
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.d("HobbyNewDialogFragment", "Save clicked, $dialog, $id")
                        //HobbyRepository.hobbies.add(Hobby(it.findViewById<EditText>(R.id.hobby_edit_text).text.toString()))

                    })
                .setNegativeButton(R.string.cancel_button,
                    DialogInterface.OnClickListener { dialog, id ->
                        Log.d("DialogFragment", "Cancel clicked, $dialog, $id")
                    })
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}