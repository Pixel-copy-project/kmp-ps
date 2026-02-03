package org.example.project.repository

import org.example.project.utill.Post

interface PostRepository {
    suspend fun getPost(): List<Post>
    suspend fun getPostByTitle(title: String): Post?
}