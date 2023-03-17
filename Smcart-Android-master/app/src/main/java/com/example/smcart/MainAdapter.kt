// 뷰페이저에서 데이터값을 화면에 설정하는 역할을 하는 클래스
inner class CustomPagerAdapter : RecyclerView.Adapter<CustomPagerAdapter.MyPagerViewHolder>() {


    // onCreateViewHolder() 메소드는 좀 전에 살펴본 ViewHolder 클래스 객체를 생성하는 역할을 하며, *.xml을 코틀린에서 사용할 수 있게 해줍니다.
    // 매개변수로 넘어오는 parent는 뷰를 보여줄 부모 뷰를 의미, viewType은 아이템에 따라 서로 다른 뷰홀더를 생성하고 싶을 때 사용할 수 있는 값
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {

        // LayoutInflater 클래스는 레이아웃 XML 파일을 코틀린에서 사용할 수 있는 객체로 변환하는 역할
        val view = LayoutInflater.from(parent.context).inflate(R.layout., parent, false)
        return MyPagerViewHolder(view)
    }


    // onBindViewHolder() 메소드는 뷰홀더에 아이템을 설정하는 메소드입니다.
    // 매개변수로는 뷰홀더와 아이템을 보여줄 위치 값(position)이 있습니다.
    // onBindViewHolder() 메소드는 어댑터 생성자에 넘어온 데이터를 뷰홀더에 매칭해주는 역할을 합니다.
    override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
        holder.bind(bgColors[position], position)
    }


    // 어댑터에 설정된 아이템 리스트의 크기를 반환하는 메소드
    // 어댑터 생성자로 넘어온 items의 크기를 반환하는 코드를 작성해야 합니다.
    override fun getItemCount(): Int {
        return bgColors.size
    }


    // 뷰홀더 클래스를 정의: onCreateViewHolder() 메소드에서 뷰 객체로 생성한 *.xml 레이아웃이 ViewHolder 생성자에 지정된 것
    // 이를 통해 itemView.findViewById<TextView>(R.id.textView)처럼 코드를 작성해서 텍스트뷰를 찾을 수 있습니다.
    inner class MyPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById<TextView>(R.id.textView)

        fun bind(@ColorRes bgColor: Int, position: Int) {
            textView.text = "$position 페이지"
            textView.textSize = 20F
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, bgColor))
        }
    }
}
