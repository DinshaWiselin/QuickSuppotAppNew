package com.example.quicksuppotapp.ui

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicksuppotapp.data.*
import com.example.quicksuppotapp.data.model.ProfileDataSupSeeker
import com.example.quicksuppotapp.data.model.ProfileDataSupporter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

class QuickSupportViewModel :ViewModel(){
    private var supportRepo = RepositorySupSeeker()
    private var supporterRepo = RepositorySupporter()
    private var firebaseAuth = FirebaseAuth.getInstance()

    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser:LiveData<FirebaseUser?>
    get() = _currentUser

    private val _toast = MutableLiveData<String?>()
    val toast:LiveData<String?>
    get() =_toast

    private val _support = MutableLiveData<MutableList<ProfileDataSupSeeker>>()
    val support: LiveData<MutableList<ProfileDataSupSeeker>>
    get() = _support

    private val _sup = MutableLiveData<ProfileDataSupSeeker>()
    val sup: LiveData<ProfileDataSupSeeker>
        get() = _sup

    private val _supseek = MutableLiveData<ProfileDataSupporter>()
    val supseek: LiveData<ProfileDataSupporter>
        get() = _supseek

    private val _supporter = MutableLiveData<MutableList<ProfileDataSupporter>>()
    val supporter: LiveData<MutableList<ProfileDataSupporter>>
        get() = _supporter

    private val repository1 = AppRepository(QuotesApi)
    val quotes = repository1.quotesData

    private val repository =NewAppRepository(NewQuoteApi)
    val quotes1 = repository.quotesData



    fun signup(email: String,password: String){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(){
                if (it.isSuccessful){
                    login(email,password)
                }
                else{
                    Log.e(TAG,"SignUp failed:${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
    }
    fun login(email:String,password:String){
       // TODO()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _currentUser.value = firebaseAuth.currentUser
                }
                else {
                   Log.e(TAG,"Login failed: ${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
    }

    fun logout(){
        firebaseAuth.signOut()
        _currentUser.value=firebaseAuth.currentUser
    }
  fun loadQuotes() {
        viewModelScope.launch {
            repository1.getQuotes(10)

        }
    }
    fun loadNewQuotes() {
        viewModelScope.launch {
            repository.getQuotes(10)

        }
    }
    init{
        getsupportlist()
        getsupporterlist()
    }
    fun setSup(sup:ProfileDataSupSeeker){
      _sup.value=sup
    }

    fun setSupSeek(supseek:ProfileDataSupporter){
        _supseek.value=supseek
    }
    private fun getsupportlist() {
        viewModelScope.launch {
            _support.value = supportRepo.loadSupportSeeker()
        }
    }
    private fun getsupporterlist() {
        viewModelScope.launch {
            _supporter.value = supporterRepo.loadsupporter()
        }
    }
     fun addsupport(support: ProfileDataSupSeeker) {
        _support.value?.add(0,support)
        _support.value = _support.value
    }
     fun addsupporter(supporter1: ProfileDataSupporter) {
        _supporter.value!!.add(0,supporter1)
        _supporter.value = _supporter.value
         Log.d("supporter list added",supporter.value.toString())

    }

}