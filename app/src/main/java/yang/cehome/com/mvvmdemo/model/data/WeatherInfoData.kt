package yang.cehome.com.mvvmdemo.model.data

/**
 * @author yangzc
 *	@data 2018/9/11 18:18
 *	@desc 生成的Data
 *
 */


data class WeatherInfoData(
    val weatherinfo: Weatherinfo
)

data class Weatherinfo(
    val AP: String,
    val Radar: String,
    val SD: String,
    val WD: String,
    val WS: String,
    val WSE: String,
    val city: String,
    val cityid: String,
    val isRadar: String,
    val njd: String,
    val sm: String,
    val temp: String,
    val time: String
)