package com.jay.livedataViewmodelTutorial

enum class ActionType{
    PLUS, MINUS
}
// 데이터의 변경
// 뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있고
//class MynumberViewModel : ViewModel() {
//
//    // mutable live data - 수정 가능
//    // live data - 수정 불가능
//
//    // 내부 변경가능
//    private val _currentValue = MutableLiveData<Int>()
//
//    val currentValue : LiveData<Int>
//        get() = _currentValue
//
//    // 뷰모델이 생성될때
//    init {
//        _currentValue.value = 0
//    }
//
//    fun updateValue(actionType: ActionType, input : Int){
//        when(actionType){
//            ActionType.PLUS -> {
//                _currentValue.value = _currentValue.value?.plus(input)
//            }
//            ActionType.MINUS -> {
//                _currentValue.value = _currentValue.value?.minus(input)
//            }
//        }
//    }
//
//}