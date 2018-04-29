package testapp.lcp.com.testapp.sharedelement

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.ImageView
import com.bumptech.glide.Glide
import testapp.lcp.com.testapp.R

/**
 * Created by Administrator on 2018/4/29.
 */
class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_detail)

        supportPostponeEnterTransition()

        var img = findViewById<ImageView>(R.id.img);

        img.viewTreeObserver.addOnPreDrawListener(

                object : ViewTreeObserver.OnPreDrawListener {

                    override fun onPreDraw(): Boolean {

                        Log.d("nnn", "onPreDraw")

                        img.viewTreeObserver.removeOnPreDrawListener(this)
                        supportStartPostponedEnterTransition()
                        return true
                    }

                })

        Glide.with(this)
                .load("http://img.hb.aicdn.com/618cf3624b263e559540e01d29d5c154708c1e7bb370-9VPSEn_fw658")
                .into(img)

    }


    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition();
    }
}