package id.co.bacainput.ViewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.co.bacainput.R
import id.co.bacainput.model.Pelanggan
import java.util.zip.Inflater

class PelangganViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(
        inflater.inflate(R.layout.item_pelanggan, parent, false)
    ) {

    var idpel: TextView? = null
    var nama: TextView? = null
    var alamat: TextView? = null
    var trfdya: TextView? = null

    init {
        idpel = itemView.findViewById(R.id.idpel)
        nama = itemView.findViewById(R.id.nama)
        alamat = itemView.findViewById(R.id.alamat)
        trfdya = itemView.findViewById(R.id.trfdya)

    }

    fun bind(data: Pelanggan) {
        idpel?.text = data.idpel
        nama?.text = data.nama
        alamat?.text = data.alamat
        trfdya?.text = "${data.tarif} / ${data.daya}VA"

    }


}