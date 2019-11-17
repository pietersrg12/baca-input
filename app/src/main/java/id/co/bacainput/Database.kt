package id.co.bacainput

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.PRIMARY_KEY
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable

class Database(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Baca", null, 1) {

    companion object {
        private var instance: Database? = null

        @Synchronized
        fun getInstance(ctx: Context): Database {
            if (instance == null) {
                instance = Database(ctx.applicationContext)
            }
            return instance!!
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            "pelanggan", true, "idpel" to TEXT + PRIMARY_KEY,
            "nama" to TEXT,
            "alamat" to TEXT,
            "tarif" to TEXT,
            "daya" to TEXT

        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}

val Context.database: Database
    get() = Database.getInstance(applicationContext)