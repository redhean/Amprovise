package project.myapplication.viewModel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import project.myapplication.R

class HomeViewModel : ViewModel() {

    val navigationItemsList = listOf<NavigationItem>(
        NavigationItem(
            title = "마이페이지",
            icon = Icons.Default.Person,
            description = "MyPage Screen",
            itemId = "mypageScreen"
        ),
        NavigationItem(
            title = "내 예약",
            icon = Icons.Default.AssignmentTurnedIn,
            description = "MyReservation Screen",
            itemId = "reservationScreen"
        ),
        NavigationItem(
            title = "찜 목록",
            icon = Icons.Default.Favorite,
            description = "Favorite Screen",
            itemId = "favoriteScreen"
        ),
        NavigationItem(
            title = "환경설정",
            icon = Icons.Default.Settings,
            description = "Settings Screen",
            itemId = "settingsScreen"
        )
    )
    
    val advertisementItemsList = listOf<AdvertisementItem>(
        AdvertisementItem(
            title = "1",
            description = "1",
            itemId = "1",
            image = R.drawable.red
        ),
        AdvertisementItem(
            title = "2",
            description = "2",
            itemId = "2",
            image = R.drawable.blue
        ),
        AdvertisementItem(
            title = "3",
            description = "3",
            itemId = "3",
            image = R.drawable.yellow
        ),
        AdvertisementItem(
            title = "4",
            description = "4",
            itemId = "4",
            image = R.drawable.violet
        ),
    )

    val spaceItemsList = listOf<SpaceItem>(
        SpaceItem(
            title = "그루브합주실 사당점",
            description = "그루브합주실 사당점",
            image = R.drawable.sadang_groove,
            min_price_per_hour = "12,000",
            star = 4.7f
        ),
        SpaceItem(
            title = "비쥬합주실 1호점",
            description = "비쥬합주실 1호점",
            image = R.drawable.sadang_bijoux1,
            min_price_per_hour = "15,000",
            star = 4.5f
        ),
        SpaceItem(
            title = "비쥬합주실 2호점",
            description = "비쥬합주실 2호점",
            image = R.drawable.sadang_bijoux2,
            min_price_per_hour = "13,000",
            star = 3.9f
        ),
        SpaceItem(
            title = "비쥬합주실 3호점",
            description = "비쥬합쥬실 3호점",
            image = R.drawable.sadang_bijoux3,
            min_price_per_hour = "16,000",
            star = 3.8f
        ),
    )

    val concertItemsList = listOf<ConcertItem>(
        ConcertItem(
            title = "Bruno Mars",
            description = "Bruno Mars",
            image = R.drawable.bruno_mars,
            isFavorite = true
        ),
        ConcertItem(
            title = "Ed Sheeran",
            description = "Ed Sheeran",
            image = R.drawable.ed_sheeran,
            isFavorite = true
        ),
        ConcertItem(
            title = "Charlie Puth",
            description = "Charlie Puth",
            image = R.drawable.charlie_puth,
            isFavorite = false
        ),
        ConcertItem(
            title = "Coldplay",
            description = "Coldplay",
            image = R.drawable.coldplay,
            isFavorite = false
        ),
    )

    val LocationItemList : List<List<String>> = listOf(
        listOf("서울", "강남/역삼/삼성/논현", "서초/신사/방배","잠실/신천(잠실새내)", "영등포/여의도", "신림/서울대/사당/동작", "천호/길동/둔촌",
            "화곡/까치산/양천/목동", "구로/금천/오류/신도림", "신촌/홍대/합정", "연신내/불광/응암", "종로/대학로/동묘앞역", "성신여대/성북/월곡", "이태원/용산/서울력/명동/회현",
            "동대문/을지로/충무로/신당/약수", "회기/고려대/청량리/신설동", "장안동/답십리", "건대/군자/구의", "왕십리/성수/금호", "수유/미아", "상봉/중랑/면목", "태릉/노원/도봉/창동"),

        listOf("경기", "수원 인계동/나혜석거리", "수원역/구운/행궁/장안구", "수원시청/권선/영통/세류", "안양/평촌/인덕원/과천", "성남/분당/위례", "용인", "동탄/화성/오산/병점", "하남/광주/여주/이천",
            "안산 중앙역", "안산 고잔/상록수/선부동/월피동", "군포/의왕/금정/산본", "시흥(월곶/정왕/오이도/거북섬)", "광명", "평택/송탄/안성", "부천", "일산/고양", "파주", "김포", "의정부",
            "구리", "남양주(다산/별내/와부/호평)", "남양주(오남/조안/화도/진접)", "포천", "양주/동두천/연천", "양평", "가평/청평", "제부도/대부도"),

        listOf("인천", "부평", "구월", "서구(석남/서구청/검단)", "계양(작전/경인교대)", "주안", "송도/연수", "인천공항/을왕리/영종도", "중구(월미도/신포/동인천/연안부두)","강화/옹진",
            "동암/간석", "남동구(소래포구/호구포)", "용현/숭의/도화/동구"),

        listOf("강원", "춘천/강촌", "원주", "경포대/사천/주문진/정동진", "강릉역/교동/옥계", "영월/정선", "속초/고성", "양양(서피비치/낙산)", "동해/삼척/태백", "평창", "홍천/횡성",
            "화천/철원/인제/양구"),

        listOf("제주", "제주공항 서부(용담,도두,연동,노형동)", "제주공항 동부(제주시청,탑동,건입동)", "서귀포시/중문/모슬포", "이호테우/하귀/애월/한림/협재", "함덕/김녕/세화", "남원/표선/성산"),

        listOf("대전", "유성구", "중구(은행/대흥/선화/유천)", "동구(용전/복합터미널)", "서구(둔산/용문/월평)", "대덕구(중리/신탄진)"),

        listOf("충북", "청주 흥덕구/서원구(청주 터미널)", "청주 상당구/청원구(청주국제공항)", "충주/수안보", "제천/단양", "진천/음성", "보은/옥천/괴산/증평/영동"),

        listOf("충남/세종", "천안 서북구", "천안 동남구", "아산", "공주/동학사/세종", "계룡/금산/논산/청양", "예산/홍성", "태안/안면도/서산", "당진", "보령/대천해수욕장", "서천/부여"),

        listOf("부산", "해운대/센텀시티.재송", "송정/기장/정관/오시리아 관광단지", "광안리/수영", "경성대/대연/용호동/문현", "서면/양정/초읍/부산시민공원", "남포동/중앙동/태종대/송도/영도",
            "부산역/범일동/부산진역", "연산/토곡", "동래/사직/미남/온천장/부산대/구서/서동", "사상(경전철)/엄궁/학장", "덕천/화명/만덕/구포(구포역/KTX역)", "하단/명지/김해공항/다대포/강서/신호/괴정/지사"),

        listOf("울산", "남구/중구(삼산/성남/무거/신정)", "동구/북구/울주군(일산/진장/진하/KTX역/영남알프스)"),

        listOf("경남", "창원 상남동/용호동/중앙동/창원시청", "창원 명서동/봉곡동/팔용동/북면온천/창원종합버스터미널", "마산", "진해", "김해/장유","양산/밀양", "진주", "거제/통영/고성",
            "사천/남해", "하동/산청/함양", "거창/함안/창녕/합천/의령"),

        listOf("대구", "동성로/서문시장/대구역/경북대", "동대구역/신천동/수성못/범어/라이온즈파크/알파시티/시지", "대구공항/혁신도시/동촌유원지/팔공산/이시아폴리스/군위", "서대구역/북부정류장/평리/비산/칠곡지구/동천동/금호지구",
            "두류/이월드/본리동/죽전동/서부정류장/앞산공원/안지랑", "성서/계명대/상인동/대곡/현풍/테크노폴리스/가창/달성군"),

        listOf("경북", "포항/남구(시청/시외버스터미널/구룡포/쌍사/문덕/오천)", "포항/북구/(영일대/죽도시장/여객터미널/송도)", "경주(보문단지/황리단길/불국사/양남/감포/안강)", "구미",
            "경산(영남대/대구대/갓바위/하양/진량/자인)", "안동(경북도청/하회마을)", "영천/청도", "김천/칠곡/성주", "문경/상주/영주/예천/의성/봉화", "울진/영덕/청송", "울릉도"),

        listOf("광주", "상무지구/금호지구/유스퀘어/서구", "충장로/대인시장/국립아시아문화전당/동구/남구", "첨단지구/양산동", "하남/광주여대/송정역/광산구", "광주역/기아챔피언스필드/전대사거리/북구"),

        listOf("전남", "여수","순천", "광양", "목포", "무안/영암/신안", "나주/함평/영광/장성", "담양/곡성/화순/구례", "해남/완도/진도/강진/장흥/보성/고흥"),

        listOf("전주/전북", "전주 덕진구", "전주 완산구/완주", "군산", "익산", "남원/임실/순창/무주/진안/장수", "정읍/부안/김제/고창"),
    )


}