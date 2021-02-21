package com.nevie.aboutme

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.nevie.aboutme.databinding.FragmentNewHobbyBinding
import com.nevie.aboutme.models.Hobby
import com.nevie.aboutme.repositories.HobbyRepository

class HobbyNewDialogFragment : DialogFragment(){
    private lateinit var onClickListener: OnClickListener

    interface OnClickListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    companion object {
        fun create(onClickListener : OnClickListener): HobbyNewDialogFragment {
            return HobbyNewDialogFragment().apply {
                this.onClickListener = onClickListener
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        // https://developer.android.com/guide/topics/ui/dialogs
        //https://code.luasoftware.com/tutorials/android/android-text-input-dialog-with-inflated-view-kotlin/
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            //val inflater = requireActivity().layoutInflater
            val layoutInflater = LayoutInflater.from(requireContext())
            val view = FragmentNewHobbyBinding.inflate(layoutInflater)

            builder.setView(view.root)
                .setPositiveButton(R.string.save_button
                ) { _: DialogInterface, _: Int ->
                    val hobbyText = view.hobbyEditText.text.toString()
                    val hobby = Hobby(hobbyText)
                    Log.d("HobbyNewDialogFragment", "Save clicked, $hobby")
                    if (hobbyText != null && hobbyText != "") {
                        HobbyRepository.hobbies.add(hobby)
                    }
                    this.onClickListener.onDialogPositiveClick()
                }
                .setNegativeButton(R.string.cancel_button
                ) { dialog, id ->
                    dismiss()
                    Log.d("HobbyNewDialogFragment", "Cancel clicked, $dialog, $id")
                }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}