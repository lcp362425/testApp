package testapp.lcp.com.testapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import testapp.lcp.com.testapp.sharedelement.SharedElementActivity

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView();
    }

    fun initView() {

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainAdapter(this)

    }


    class MainAdapter(var mContext: Context) : RecyclerView.Adapter<MainViewHolder>() {

        var mains = mContext.resources.getStringArray(R.array.mains)

        override fun getItemCount(): Int {
            return mains.size
        }

        override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
            val index = position
            holder?.nameTv?.setText(mains[position])
            holder?.nameTv?.setOnClickListener { view ->

                var intent: Intent? = null

                when (index) {

                    0 ->
                        intent = Intent(mContext, SharedElementActivity::class.java)

                }

                mContext.startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
            var view = View.inflate(mContext, R.layout.item_main, null)
            return MainViewHolder(view)
        }


    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nameTv: TextView = itemView.findViewById(R.id.name_tv)

    }
}
