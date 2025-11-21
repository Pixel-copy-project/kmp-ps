package org.example.project.repository

import org.example.project.utill.Notice

interface NoticeRepository {
    suspend fun getNoticeList(): List<Notice>
    suspend fun getNoticeByTitle(title: String): Notice?
}