package com.neta.tugasper6_tiketing

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.R
import com.neta.tugasper6_tiketing.databinding.ActivityMainBinding
import java.time.Clock
import java.util.Calendar
import java.util.TimeZone
import java.util.Timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayOf(
            "Kulon Progo",
            "Bantul",
            "Keraton",
            "Sleman",
            "Gunung Kidul"
        )

        val usia = arrayOf(
            "Anak-anak",
            "Dewasa"
        )

        val kelas = arrayOf(
            "Eksekutif",
            "Premium Eksekutif",
            "Premium",
            "Ekonomi"
        )




        with(binding) {
            val countriesAdapter = ArrayAdapter(
                this@MainActivity,
                R.layout.support_simple_spinner_dropdown_item,
                countries
            )

            countriesAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinCountries1.adapter = countriesAdapter
            spinCountries2.adapter = countriesAdapter

            val usiaAdapter = ArrayAdapter(
                this@MainActivity,
                R.layout.support_simple_spinner_dropdown_item,
                usia
            )

            usiaAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinUsia.adapter = usiaAdapter

            val kelasAdapter = ArrayAdapter(
                this@MainActivity,
                R.layout.support_simple_spinner_dropdown_item,
                kelas
            )

            kelasAdapter.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            )

            spinKelas.adapter = kelasAdapter

            butttonCalendar.setOnClickListener{
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val cal = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth -> tanggalInput.setText(""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year)}
                , year, month, day )
                cal.show()
            }

            buttonClock.setOnClickListener{
                val jam = Calendar.getInstance()
                val hour = jam.get(Calendar.HOUR_OF_DAY)
                val minutes = jam.get(Calendar.MINUTE)

                val jm = TimePickerDialog(this@MainActivity, TimePickerDialog.OnTimeSetListener { _, hours, minutess -> waktuInput.setText(""+hours+":"+minutess+" WIB")}
                    , hour, minutes, false)
                    jm.show()
            }

            buttonPesan.setOnClickListener{
                val nama =  namaPemesan.text.toString()
                val tanggal = tanggalInput.text.toString()
                val waktu = waktuInput.text.toString()
                Toast.makeText(this@MainActivity, nama + " berangkat tanggal "+ tanggal + ", pada pukul " + waktu, Toast.LENGTH_LONG).show()
            }

        }
    }
}