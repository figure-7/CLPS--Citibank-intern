module.exports = {
    devServer: {
        disableHostCheck: true,
        proxy: {
            "/api": {
                target: "http://localhost:8001",
                pathRewrite: {
                    "^/api": ""
                }
            }
        }
    },
    configureWebpack: {
        devServer: {
            before(app) {
                app.get("/api/toDos", function (req, res) {
                    res.json({
                        code: 0,
                        data: [
                            {
                                id: 1,
                                summary: "会议摘要1",
                                creatDateTime: "20200522132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 2,
                                summary: "会议摘要2",
                                creatDateTime: "20200511132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 3,
                                summary: "会议摘要3",
                                creatDateTime: "20200502132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 4,
                                summary: "会议摘要4",
                                creatDateTime: "20200502092216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 5,
                                summary: "会议摘要5",
                                creatDateTime: "20200501132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 6,
                                summary: "会议摘要6",
                                creatDateTime: "20200429132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 7,
                                summary: "会议摘要7",
                                creatDateTime: "20200428132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 8,
                                summary: "会议摘要8",
                                creatDateTime: "20200425132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 9,
                                summary: "会议摘要9",
                                creatDateTime: "20200422132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            },
                            {
                                id: 10,
                                summary: "会议摘要10",
                                creatDateTime: "20200420132216",
                                startDateTime: "NA",
                                endDateTime: "NA",
                                status: "C"
                            }
                        ]
                    });
                });
            }
        }
    }
}