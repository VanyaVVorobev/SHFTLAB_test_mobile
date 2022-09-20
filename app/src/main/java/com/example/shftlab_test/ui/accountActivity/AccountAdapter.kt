package com.example.shftlab_test.ui.accountActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shftlab_test.R
import com.example.shftlab_test.domain.model.Account

class AccountAdapter(
    private val context: Context,
    private val accounts: Array<Account>
    ): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    val viewList: ArrayList<LinearLayout> = arrayListOf()

    override fun getCount(): Int {
        return accounts.size
    }

    override fun getItem(p0: Int): Any {
        return accounts[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.account_item, p2, false)
        rowView.findViewById<ImageView>(R.id.image).setBackgroundResource(R.drawable.ic_launcher_foreground)
        rowView.findViewById<TextView>(R.id.name).text = accounts[p0].name
        viewList.add(rowView.findViewById(R.id.root))
        return rowView
    }
}