package pe.com.dev420.listados.recyclerview.grid.itemdecoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacesItemDecoration(private val space: Int): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect?.left = space
        outRect?.right = space
        outRect?.bottom = space

        if (parent?.getChildLayoutPosition(view) == 0) {
            outRect?.top = space
        } else {
            outRect?.top = 0
        }
    }
}