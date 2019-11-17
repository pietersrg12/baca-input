package id.co.bacainput

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.bacainput.Adapter.AdapterPelanggan
import id.co.bacainput.model.Pelanggan
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class HomeActivity : AppCompatActivity() {

    var listPlg = mutableListOf<Pelanggan>()
    val adapterPlg = AdapterPelanggan(listPlg)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        toolbarhome.setTitle("VIP Customer")
        setSupportActionBar(toolbarhome)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)


        rv.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = adapterPlg

        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tambah -> {
                val intentForm = Intent(this, FormActivity::class.java)
                startActivity(intentForm)
            }
        }

        return super.onOptionsItemSelected(item)

    }


    override fun onResume() {
        bacaDatabase()
        super.onResume()
    }

    fun bacaDatabase() {
        database.use {
            select("pelanggan").exec {
                while (this.moveToNext()) {
                    listPlg.add(
                        Pelanggan(
                            getString(getColumnIndex("idpel")),
                            getString(getColumnIndex("nama")),
                            getString(getColumnIndex("alamat")),
                            getString(getColumnIndex("tarif")),
                            getString(getColumnIndex("daya"))
                        )
                    )

                }
                adapterPlg.notifyDataSetChanged()
            }
        }
    }

}
