package com.hardik.cleanarchitecture.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.hardik.cleanarchitecture.domain.model.CoinDetail


data class CoinDetailDto(
    @SerializedName("description") val description: String = "", // Bitcoin is a cryptocurrency and worldwide payment system. It is the first decentralized digital currency, as the system works without a central bank or single administrator.
    @SerializedName("development_status") val developmentStatus: String = "", // Working product
    @SerializedName("first_data_at") val firstDataAt: String = "", // 2010-07-17T00:00:00Z
    @SerializedName("hardware_wallet") val hardwareWallet: Boolean = false, // true
    @SerializedName("hash_algorithm") val hashAlgorithm: String = "", // SHA256
    @SerializedName("id") val id: String = "", // btc-bitcoin
    @SerializedName("is_active") val isActive: Boolean = false, // true
    @SerializedName("is_new") val isNew: Boolean = false, // false
    @SerializedName("last_data_at") val lastDataAt: String = "", // 2024-03-20T06:03:00Z
    @SerializedName("links") val links: Links = Links(),
    @SerializedName("links_extended") val linksExtended: List<LinksExtended> = listOf(),
    @SerializedName("logo") val logo: String = "", // https://static.coinpaprika.com/coin/btc-bitcoin/logo.png
    @SerializedName("message") val message: String = "",
    @SerializedName("name") val name: String = "", // Bitcoin
    @SerializedName("open_source") val openSource: Boolean = false, // true
    @SerializedName("org_structure") val orgStructure: String = "", // Decentralized
    @SerializedName("proof_type") val proofType: String = "", // Proof of Work
    @SerializedName("rank") val rank: Int = 0, // 1
    @SerializedName("started_at") val startedAt: String = "", // 2009-01-03T00:00:00Z
    @SerializedName("symbol") val symbol: String = "", // BTC
    @SerializedName("tags") val tags: List<Tag> = listOf(),
    @SerializedName("team") val team: List<TeamMember> = listOf(),
    @SerializedName("type") val type: String = "", // coin
    @SerializedName("whitepaper") val whitepaper: Whitepaper = Whitepaper()
) {

    data class Links(
        @SerializedName("explorer") val explorer: List<String> = listOf(),
        @SerializedName("facebook") val facebook: List<String> = listOf(),
        @SerializedName("reddit") val reddit: List<String> = listOf(),
        @SerializedName("source_code") val sourceCode: List<String> = listOf(),
        @SerializedName("website") val website: List<String> = listOf(),
        @SerializedName("youtube") val youtube: List<String> = listOf()
    )


    data class LinksExtended(
        @SerializedName("stats") val stats: Stats? = null,
        @SerializedName("type") val type: String = "", // blog
        @SerializedName("url") val url: String = "" // https://bitcoin.org/en/blog
    ) {

        data class Stats(
            @SerializedName("contributors") val contributors: Int? = null, // 1174
            @SerializedName("followers") val followers: Int? = null, // 161310
            @SerializedName("stars") val stars: Int? = null, // 74898
            @SerializedName("subscribers") val subscribers: Int? = null // 5958815
        )
    }


    data class Tag(
        @SerializedName("coin_counter") val coinCounter: Int = 0, // 10
        @SerializedName("ico_counter") val icoCounter: Int = 0, // 0
        @SerializedName("id") val id: String = "", // segwit
        @SerializedName("name") val name: String = "" // Segwit
    )


    data class TeamMember(
        @SerializedName("id") val id: String = "", // satoshi-nakamoto
        @SerializedName("name") val name: String = "", // Satoshi Nakamoto
        @SerializedName("position") val position: String = "" // Founder
    )


    data class Whitepaper(
        @SerializedName("link") val link: String = "", // https://static.coinpaprika.com/storage/cdn/whitepapers/215.pdf
        @SerializedName("thumbnail") val thumbnail: String = "" // https://static.coinpaprika.com/storage/cdn/whitepapers/217.jpg
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team
    )
}