package org.example.project.repository

import org.example.project.utill.Post

interface PostRepository {
    suspend fun getPost(): List<Post>
    suspend fun getPost(page: Int = 1, pageSize: Int = 20): List<Post>
    suspend fun getPostByCategory(category: String,
                                  page: Int = 1,
                                  pageSize: Int = 20): List<Post>
    suspend fun getCountByCategory(category: String): Int
    suspend fun getPostById(id: String): Post?
    suspend fun getPostByTitle(title: String): Post?
}