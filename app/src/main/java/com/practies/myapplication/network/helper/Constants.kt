package com.practies.myapplication.network.helper

object Constants {
    const val BASE_URL:String="https://sps-backend-api.herokuapp.com"


    //student management
    const val GET_ALL_BATCH:String="/teacher//getAllBatches"
    const val GET_STUDENTS:String="/teacher/getAllStudents"
    const val ADD_STUDENT:String="/teacher/addStudent"


    //domain management
    const val GET_ALL_DOMAINS:String="/teacher//getAllDomains"
    const val ADD_DOMAIN:String="/teacher/addNewDomain"  //pass string as new domain name
    const val DELETE_DOMAIN:String="/teacher/deleteDomain"

    //reviewer management
    const val GET_ALL_REVIEWERS="/teacher/getAllReviewer"
    const val ADD_NEW_REVIEWER="/teacher/addNewReviewer"
    const val DELETE_REVIEWER="/teacher/deleteReviewer/:id"
}

// including identifying memory leaks, performance bottlenecks, and using tools like adb, proguard, etc