package testapp.lcp.com.testapp.sharedelement

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import testapp.lcp.com.testapp.BuildConfig
import testapp.lcp.com.testapp.R

/**
 * Created by Administrator on 2018/4/29.
 */
class SharedElementActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element)

        initView();
    }

    fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = SharedAdapter(this)

    }

    inner class SharedAdapter(var context: Context) : RecyclerView.Adapter<ShareViewHolder>() {

        override fun onBindViewHolder(holder: ShareViewHolder?, position: Int) {
            holder?.img?.setImageResource(R.mipmap.ic_launcher_round)
            holder?.img?.setOnClickListener { view ->
                var intent = Intent(context, DetailActivity::class.java)

                //单个共享元素
                var option = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this@SharedElementActivity, view, "sharedElement")
                //多个共享元素

                var p1 = Pair.create(view,"sharedElement")
                ActivityOptionsCompat.makeSceneTransitionAnimation(this@SharedElementActivity,p1)

                context.startActivity(intent, option.toBundle())
            }
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ShareViewHolder {
            var view = View.inflate(context, R.layout.item_shared_element, null)
            return ShareViewHolder(view)
        }

    }

    class ShareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img = itemView.findViewById<ImageView>(R.id.img)

    }

}