package me.csxiong.uiux.ui.studio

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class BookStudioViewModel  constructor(application: Application) : AndroidViewModel(application) {

    val bottomFunctionChangeEvent = MutableLiveData<BottomFunction>()

    fun show(function: BottomFunction?) {
        bottomFunctionChangeEvent.value = function
    }

    fun isShow(): Boolean {
        return bottomFunctionChangeEvent.value != null
    }

    fun isShow(bottomFunction: BottomFunction): Boolean {
        return bottomFunctionChangeEvent.value == bottomFunction
    }

}