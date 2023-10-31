package com.example.mangaapirequest.model

import com.google.gson.annotations.SerializedName

data class MangaApiResponse(

    @SerializedName("pagination" ) var pagination : Pagination?     = Pagination(),
    @SerializedName("data"       ) var data       : ArrayList<Data> = arrayListOf()

)
data class Items (

    @SerializedName("count"    ) var count   : Int? = null,
    @SerializedName("total"    ) var total   : Int? = null,
    @SerializedName("per_page" ) var perPage : Int? = null

)



data class Pagination (

    @SerializedName("last_visible_page" ) var lastVisiblePage : Int?     = null,
    @SerializedName("has_next_page"     ) var hasNextPage     : Boolean? = null,
    @SerializedName("current_page"      ) var currentPage     : Int?     = null,
    @SerializedName("items"             ) var items           : Items?   = Items()

)


data class Jpg (

    @SerializedName("image_url"       ) var imageUrl      : String? = null,
    @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
    @SerializedName("large_image_url" ) var largeImageUrl : String? = null

)


data class Webp (

    @SerializedName("image_url"       ) var imageUrl      : String? = null,
    @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
    @SerializedName("large_image_url" ) var largeImageUrl : String? = null

)

data class Images (

    @SerializedName("jpg"  ) var jpg  : Jpg?  = Jpg(),
    @SerializedName("webp" ) var webp : Webp? = Webp()

)

data class Jpeg (

    @SerializedName("image_url"         ) var imageUrl        : String? = null,
    @SerializedName("small_image_url"   ) var smallImageUrl   : String? = null,
    @SerializedName("medium_image_url"  ) var mediumImageUrl  : String? = null,
    @SerializedName("large_image_url"   ) var largeImageUrl   : String? = null,
    @SerializedName("maximum_image_url" ) var maximumImageUrl : String? = null
)


data class Trailer (

    @SerializedName("youtube_id" ) var youtubeId : String? = null,
    @SerializedName("url"        ) var url       : String? = null,
    @SerializedName("embed_url"  ) var embedUrl  : String? = null,
    @SerializedName("images"     ) var images    : Images? = Images()

)

data class Titles (

    @SerializedName("type"  ) var type  : String? = null,
    @SerializedName("title" ) var title : String? = null

)

data class From (

    @SerializedName("day"   ) var day   : Int? = null,
    @SerializedName("month" ) var month : Int? = null,
    @SerializedName("year"  ) var year  : Int? = null

)

data class To (

    @SerializedName("day"   ) var day   : String? = null,
    @SerializedName("month" ) var month : String? = null,
    @SerializedName("year"  ) var year  : String? = null

)
data class Prop (

    @SerializedName("from" ) var from : From? = From(),
    @SerializedName("to"   ) var to   : To?   = To()

)


data class Aired (

    @SerializedName("from"   ) var from   : String? = null,
    @SerializedName("to"     ) var to     : String? = null,
    @SerializedName("prop"   ) var prop   : Prop?   = Prop(),
    @SerializedName("string" ) var string : String? = null

)

data class Broadcast (

    @SerializedName("day"      ) var day      : String? = null,
    @SerializedName("time"     ) var time     : String? = null,
    @SerializedName("timezone" ) var timezone : String? = null,
    @SerializedName("string"   ) var string   : String? = null

)


data class Producers (

    @SerializedName("mal_id" ) var malId : Int?    = null,
    @SerializedName("type"   ) var type  : String? = null,
    @SerializedName("name"   ) var name  : String? = null,
    @SerializedName("url"    ) var url   : String? = null

)

data class Studios (

    @SerializedName("mal_id" ) var malId : Int?    = null,
    @SerializedName("type"   ) var type  : String? = null,
    @SerializedName("name"   ) var name  : String? = null,
    @SerializedName("url"    ) var url   : String? = null

)

data class Genres (

    @SerializedName("mal_id" ) var malId : Int?    = null,
    @SerializedName("type"   ) var type  : String? = null,
    @SerializedName("name"   ) var name  : String? = null,
    @SerializedName("url"    ) var url   : String? = null

)

data class Demographics (

    @SerializedName("mal_id" ) var malId : Int?    = null,
    @SerializedName("type"   ) var type  : String? = null,
    @SerializedName("name"   ) var name  : String? = null,
    @SerializedName("url"    ) var url   : String? = null

)


data class Data (

    @SerializedName("mal_id"          ) var malId          : Int?                    = null,
    @SerializedName("url"             ) var url            : String?                 = null,
    @SerializedName("images"          ) var images         : Images?                 = Images(),
    @SerializedName("trailer"         ) var trailer        : Trailer?                = Trailer(),
    @SerializedName("approved"        ) var approved       : Boolean?                = null,
    @SerializedName("titles"          ) var titles         : ArrayList<Titles>       = arrayListOf(),
    @SerializedName("title"           ) var title          : String?                 = null,
    @SerializedName("title_english"   ) var titleEnglish   : String?                 = null,
    @SerializedName("title_japanese"  ) var titleJapanese  : String?                 = null,
    @SerializedName("title_synonyms"  ) var titleSynonyms  : ArrayList<String>       = arrayListOf(),
    @SerializedName("type"            ) var type           : String?                 = null,
    @SerializedName("source"          ) var source         : String?                 = null,
    @SerializedName("episodes"        ) var episodes       : Int?                    = null,
    @SerializedName("status"          ) var status         : String?                 = null,
    @SerializedName("airing"          ) var airing         : Boolean?                = null,
    @SerializedName("aired"           ) var aired          : Aired?                  = Aired(),
    @SerializedName("duration"        ) var duration       : String?                 = null,
    @SerializedName("rating"          ) var rating         : String?                 = null,
    @SerializedName("score"           ) var score          : Double?                 = null,
    @SerializedName("scored_by"       ) var scoredBy       : Int?                    = null,
    @SerializedName("rank"            ) var rank           : Int?                    = null,
    @SerializedName("popularity"      ) var popularity     : Int?                    = null,
    @SerializedName("members"         ) var members        : Int?                    = null,
    @SerializedName("favorites"       ) var favorites      : Int?                    = null,
    @SerializedName("synopsis"        ) var synopsis       : String?                 = null,


    )