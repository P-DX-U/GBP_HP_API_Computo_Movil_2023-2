package com.third.gbp_hp_api_computo_movil_2023_2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class infoCharacter(var name: String?,
                    var species: String?,
                    var ancestry: String?,
                    var wood: String?,
                    var core: String?,
                    var patronus: String?,
                    var birthday: String?): Parcelable