package com.example.crud.RequestDTO;

import org.antlr.v4.runtime.misc.NotNull;

public record RequestProductDTO(

        String id,

        String name,

        int price_in_cents) {
}
