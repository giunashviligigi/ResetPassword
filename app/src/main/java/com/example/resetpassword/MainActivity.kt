package com.example.resetpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var phonenumber: EditText
    private lateinit var smscode: EditText
    private lateinit var newpassword: EditText
    private lateinit var repeatpassword: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phonenumber = findViewById(R.id.phonenumber)
        smscode = findViewById(R.id.smscode)
        newpassword = findViewById(R.id.newpassword)
        repeatpassword = findViewById(R.id.repeatpassword)
        button = findViewById(R.id.button)



        button.setOnClickListener {
            when {
                TextUtils.isEmpty(phonenumber.text.toString().trim()) -> {
                    phonenumber.error = "გთხოვთ შეიყვანოთ ტელეფონის ნომერი"
                }
                TextUtils.isEmpty(smscode.text.toString().trim()) -> {
                    smscode.error = "გთხოვთ შეიყვანოთ გამოგზავნილი კოდი"
                }
                TextUtils.isEmpty(newpassword.text.toString().trim()) -> {
                    newpassword.error = "გთხოვთ შეიყვანოთ ახალი პაროლი"
                }
                TextUtils.isEmpty(repeatpassword.text.toString().trim()) -> {
                    repeatpassword.error = "გთხოვთ გაიმეოროთ პაროლი"
                }

                phonenumber.text.toString().isNotEmpty() and smscode.text.toString().isNotEmpty() and
                        newpassword.text.toString().isNotEmpty() and
                        repeatpassword.text.toString().isNotEmpty()-> {
                    if (phonenumber.text.toString().length == 9 && phonenumber.text.toString().startsWith("5")) {
                        if (smscode.text.toString().length == 4 || smscode.text.toString().length == 6)  {
                            if (newpassword.text.toString() == repeatpassword.text.toString()) {
                                Toast.makeText(applicationContext,"თქვენ წარმატებით შეცვალეთ პაროლი", Toast.LENGTH_LONG).show()
                            }
                            else {
                                repeatpassword.error =
                                    "თქვენს მიერ შეყვანილი პაროლი არ ემთხვევა ახალ პაროლს"
                            }
                        }
                        else {
                            smscode.error = "აკრეფილი კოდი უნდა შედგებოდეს 4 ან 6 სიმბოლოსგან"
                        }
                    }
                    else{
                        phonenumber.error = "მობილურის ნომერი უნდა იწყებოდეს 5-ით და შედგებოდეს 9 სიმბოლოსგან"
                    }

                }

            }
        }
    }

}