package com.example.alertdialogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img_btn:ImageView=findViewById(R.id.img_button)
        /**
         * using snack bar instead of toast the syntax is given below
         */
        img_btn.setOnClickListener {view ->
            Snackbar.make(view,"You have clicked the image button.",Snackbar.LENGTH_SHORT).show()
        }
        /**
         * creating for alert dialog
         */
        val bt1:Button=findViewById(R.id.button_1)
        bt1.setOnClickListener {
            alertDialogfunctino()
        }

    }
    /**
     * to create alert dialog we first of all create a private function and a builder
     */
    private fun alertDialogfunctino()
    {
        //we first create a builder
        val builder = AlertDialog.Builder(this) //creating a variable which is object of Builder
        //now settting title for alert dialog
        builder.setTitle("Alert")
        //now setting message for alert dialog
        builder.setMessage("This is a alert dialog which is used to show alert")
        builder.setIcon(android.R.drawable.ic_dialog_alert)//setting an icon for alert
        //now performing positive action
        builder.setPositiveButton("Yes")
        {
            //this block is executed when positive button is clicked in this case when "yes" is clicked
            dialogInterface,which -> //dialog,which-> can also be used
            Toast.makeText(this,"clicked yes",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()//dialog will be dismissed
        }
        //performing neutral action
        /**
         * positive may be yes,okay
         * negative may be no,cancel
         * neutral may be details,click to know more etc
         */

        builder.setNeutralButton("cancel")
        {
            dialoginterface,which->//dialog,which-> can also be used
            Toast.makeText(this,"you clicked cancel",Toast.LENGTH_SHORT).show()
            dialoginterface.dismiss() //dialog will be dismissed
        }
        builder.setNegativeButton("No")
        {
            dia,which->//you can write anything dia,dialog,sans,noob......
            Toast.makeText(this,"clicked No",Toast.LENGTH_SHORT).show()
            dia.dismiss()
        }
            //when everything is setup we will create an alert dialog using builder
        val alertDialog:AlertDialog=builder.create()
        //setting other dialog properties
        alertDialog.setCancelable(false)//will not allow user to cancel after clicking on the remaining screen area
        //if set to true it will get canceled if pressed on remaining screen
        alertDialog.show()
        /**
         * it can be done like this also without creating alertDialog ,both are same
         * builder.create()
         * builder.show()
         */
    }
}