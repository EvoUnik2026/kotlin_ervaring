package com.courseflow.domain.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CourseIdTest : StringSpec({

    "CourseId mag geen 0 of negatieve waarde bevatten" {
        val exception = shouldThrow<IllegalArgumentException> {
            CourseId(0)
        }
        exception.message shouldBe "CourseId moet groter zijn dan 0"
    }

    "CourseId maakt correct aan bij een positieve waarde" {
        val id = CourseId(42)
        id.value shouldBe 42
    }
})