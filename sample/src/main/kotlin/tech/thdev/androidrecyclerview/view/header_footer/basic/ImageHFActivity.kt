package tech.thdev.androidrecyclerview.view.header_footer.basic

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import tech.thdev.androidrecyclerview.R
import tech.thdev.base.util.replaceContentFragment
import tech.thdev.base.view.BaseActivity

/**
 * Created by Tae-hwan on 17/10/2016.
 */

class ImageHFActivity : BaseActivity() {

    private val collapsingToolbar by lazy {
        findViewById(R.id.collapsing_toolbar) as CollapsingToolbarLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_view)

        collapsingToolbar.title = getString(R.string.label_activity_header_footer_sample)

        replaceContentFragment(R.id.frame_layout, ImageHFFragment.getInstance())
    }
}