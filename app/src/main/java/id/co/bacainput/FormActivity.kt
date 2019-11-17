package id.co.bacainput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import id.co.bacainput.Adapter.AdapterPelanggan
import id.co.bacainput.model.Pelanggan
import kotlinx.android.synthetic.main.activity_form.*
import org.jetbrains.anko.db.insert

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        toolbarform.setTitle("Tambah Data")
        setSupportActionBar(toolbarform)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.simpan -> {
                database.use {
                    insert(
                        "pelanggan",
                        "idpel" to idpel.text.toString(),
                        "nama" to nama.text.toString(),
                        "alamat" to alamat.text.toString(),
                        "tarif" to tarif.text.toString(),
                        "daya" to daya.text.toString()
                    )
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }


}
