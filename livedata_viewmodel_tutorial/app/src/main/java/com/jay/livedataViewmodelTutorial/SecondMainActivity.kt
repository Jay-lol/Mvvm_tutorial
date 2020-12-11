package com.jay.livedataViewmodelTutorial

//class SecondMainActivity : AppCompatActivity(), View.OnClickListener {
//
//    lateinit var mynumberViewModel: MynumberViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_activity_main)
//
//        // 뷰모델 인스턴스를 ViewModelProvider를 통해 가져온다
//        mynumberViewModel = ViewModelProvider(this).get(MynumberViewModel::class.java)
//
//        // 옵저버 패턴. 자료형이 라이브데이터인 currentValue .데이터가 변경되는것을 캐치해서 변경
//        mynumberViewModel.currentValue.observe(this, Observer {
//            number_textView.text = it.toString()
//        })
//
//        // 리스너 연결
//        plus_btn.setOnClickListener(this)
//        minus_btn.setOnClickListener(this)
//
//    }
//
//    override fun onClick(view: View?) {
//        val userInput = userinput_edittext.text.toString().toInt()
//        when(view){
//            plus_btn ->
//                mynumberViewModel.updateValue(actionType = ActionType.PLUS, input = userInput)
//            minus_btn ->
//                mynumberViewModel.updateValue(actionType = ActionType.MINUS, input = userInput)
//        }
//    }
//}