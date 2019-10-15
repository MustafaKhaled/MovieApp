import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class MovieDetails (

	@SerializedName("adult") val adult : Boolean,
	@SerializedName("backdrop_path") val backdrop_path : String,
	@SerializedName("belongs_to_collection") val belongs_to_collection : String,
	@SerializedName("budget") val budget : Int,
	@SerializedName("genres") val genres : List<Genres>,
	@SerializedName("homepage") val homepage : String,
	@SerializedName("id") val id : Int,
	@SerializedName("imdb_id") val imdb_id : String,
	@SerializedName("original_language") val original_language : String,
	@SerializedName("original_title") val original_title : String,
	@SerializedName("overview") val overview : String,
	@SerializedName("popularity") val popularity : Double,
	@SerializedName("poster_path") val poster_path : String,
	@SerializedName("production_companies") val production_companies : List<ProductionCompanies>,
	@SerializedName("production_countries") val production_countries : List<ProductionCountries>,
	@SerializedName("release_date") val release_date : String,
	@SerializedName("revenue") val revenue : Int,
	@SerializedName("runtime") val runtime : Int,
	@SerializedName("spoken_languages") val spoken_languages : List<SpokenLanguages>,
	@SerializedName("status") val status : String,
	@SerializedName("tagline") val tagline : String,
	@SerializedName("title") val title : String,
	@SerializedName("video") val video : Boolean,
	@SerializedName("vote_average") val vote_average : Double,
	@SerializedName("vote_count") val vote_count : Int
)