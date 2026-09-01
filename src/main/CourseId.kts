package com.courseflow.domain.model

@JvmInline
value class CourseId(val value: Long) {
    init {
        require(value > 0) { "CourseId moet groter zijn dan 0" }
    }
}