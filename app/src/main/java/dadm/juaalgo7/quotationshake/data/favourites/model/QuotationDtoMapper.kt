package dadm.juaalgo7.quotationshake.data.favourites.model

import dadm.juaalgo7.quotationshake.ui.model.Quotation


fun QuotationDto.toDomain() = Quotation(id = identifier, text = text, author= author)

fun Quotation.toDto() = QuotationDto(identifier = id, text = text, author = author)