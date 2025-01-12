package io.swagger.client.infrastructure

import okhttp3.Response

/**
 * Provides an extension to evaluation whether the response is a 1xx code
 */
val Response.isInformational: Boolean get() = this.code in 100..199

/**
 * Provides an extension to evaluation whether the response is a 4xx code
 */
val Response.isClientError: Boolean get() = this.code in 400..499

