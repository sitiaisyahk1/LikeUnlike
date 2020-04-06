package com.sitiaisyah.idn.likeunlike.common

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), Observable{

    private val callbacks : PropertyChangeRegistry = PropertyChangeRegistry()
    override fun removeOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    fun notifyPropertyChanged(position: Int){
        callbacks.notifyCallbacks(this, position, null)
    }
}