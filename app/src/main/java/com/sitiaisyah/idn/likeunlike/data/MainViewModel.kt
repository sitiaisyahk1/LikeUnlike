package com.sitiaisyah.idn.likeunlike.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sitiaisyah.idn.likeunlike.common.BaseViewModel

class MainViewModel : ViewModel() {
    private val _likeNumber = MutableLiveData(0)
    private val _unLikeNumber = MutableLiveData(0)

    val likeNumbers: LiveData<Int> = _likeNumber
    val unLikeNumbers: LiveData<Int> = _unLikeNumber

    val popularity: LiveData<MainObservableViewModel.LikeNumbers> =
        Transformations.map(_likeNumber) {
            when {
                it > 9 -> MainObservableViewModel.LikeNumbers.STAR
                it > 5 -> MainObservableViewModel.LikeNumbers.POPULAR
                else -> MainObservableViewModel.LikeNumbers.NORMAL
            }
        }

    val unPopularity: LiveData<MainObservableViewModel.UnLikeNumbers> =
        Transformations.map(_unLikeNumber) {
            when {
                it > 9 -> MainObservableViewModel.UnLikeNumbers.UNSATISFYING
                it > 5 -> MainObservableViewModel.UnLikeNumbers.NOTPOPULAR
                else -> MainObservableViewModel.UnLikeNumbers.NORMAL
            }
        }

    fun onLike() {
        _likeNumber.value = (_likeNumber.value ?: 0) + 1
    }

    fun onUnLike() {
        _unLikeNumber.value = (_unLikeNumber.value ?: 0) + 1
    }
}

class MainObservableViewModel : BaseViewModel() {
    enum class LikeNumbers {
        NORMAL, POPULAR, STAR
    }

    enum class UnLikeNumbers {
        NORMAL, NOTPOPULAR, UNSATISFYING
    }
}
