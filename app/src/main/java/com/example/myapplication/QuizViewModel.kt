package com.example.myapplication

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG="QuiziewModel"
const val CURRENT_INDEX_KEY="CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY="IS_CHEATER_KEY"
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Questions(R.string.question_australia, true),
        Questions(R.string.question_asia, false),
        Questions(R.string.question_oceans,true)
    )
    var isCheater:Boolean
        get()=savedStateHandle.get(IS_CHEATER_KEY)?:false
        set(value)=savedStateHandle.set(IS_CHEATER_KEY,value)
    private var currentIndex: Int get()=savedStateHandle.get(CURRENT_INDEX_KEY)?:0
    set(value)=savedStateHandle.set(CURRENT_INDEX_KEY,value)
    val currentQuestionsAnswer:Boolean get()=questionBank[currentIndex].answer
    val currentQuestionText:Int get()=questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex=(currentIndex+1)%questionBank.size
    }
    fun resetCheater(){
        isCheater=false
    }

}