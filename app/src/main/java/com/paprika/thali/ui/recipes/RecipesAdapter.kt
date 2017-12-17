package com.paprika.thali.ui.recipes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paprika.thali.R
import com.paprika.thali.data.db.room.Recipe
import com.paprika.thali.utils.GlideApp
import kotlinx.android.synthetic.main.recipe_list_item.view.*

/**
 * Created by vicky on 17/12/17.
 */

class RecipesAdapter(private val recipeList: MutableList<Recipe>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun addItems(recipes: MutableList<Recipe>?) {
        if (recipes != null) {
            recipeList?.clear()
            recipeList?.addAll(recipes)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? RecipeHolder)?.onBind(recipeList!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RecipeHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recipe_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return recipeList!!.size
    }

    class RecipeHolder(itemView_: View) : RecyclerView.ViewHolder(itemView_) {
        fun onBind(recipe: Recipe) {
            GlideApp.with(itemView.context)
                    .load(recipe.imageUrl)
                    .centerCrop()
                    .into(itemView.image_view)

            itemView.name.text = recipe.recipeName
        }
    }
}