package com.multi.trivia.ui.quiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multi.trivia.data.model.QuizResponse
import com.multi.trivia.data.repository.TriviaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val triviaRepository: TriviaRepository
) : ViewModel() {

    lateinit var questionList: MutableLiveData<Response<QuizResponse>>

    fun fetchQuiz(amount: Int, category: Long, difficulty: String, type: String) {

        questionList = MutableLiveData()

        viewModelScope.launch(Dispatchers.IO) {
            val response = triviaRepository.fetchQuiz(amount, category, difficulty, type)
            questionList.postValue(response)
        }
    }

}