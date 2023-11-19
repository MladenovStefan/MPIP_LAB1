package com.example.lab_intents.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _userChoice : MutableLiveData<String> by lazy {
        MutableLiveData<String>();
    }

    fun getUserChoice():String{
        return _userChoice.value.toString();
    }

    fun setUserChoice(choice:String){
        this._userChoice.value = choice;
    }

    fun getUserChoiceValue(): MutableLiveData<String>{
        return this._userChoice;
    }

}