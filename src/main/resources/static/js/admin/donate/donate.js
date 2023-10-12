window.onload = function () {

    /* 기부 통계 차트 */

        // 차트를 생성하는 함수
        function createChart(data) {
            const ctx = document.getElementById('total-donateChart').getContext('2d');

            if (donateChart) {
                donateChart.destroy();
            }

            donateChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
                    datasets: [{
                        label: '누적 기부 금액',
                        data: data,
                        backgroundColor: '#426eb0',
                        borderColor: '#998181',
                        borderWidth: 1,
                        datalabels: {
                            anchor: 'end',
                            align: 'top',
                            font: { size: 12, weight: 'bold' },
                            color: 'black',
                        }
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    maintainAspectRatio: false,
                    responsive: true,
                    plugins: {
                        legend: {
                            display: true,
                            position: 'top',
                        },
                        datalabels: {
                            anchor: 'end',
                            align: 'top',
                            font: { size: 12, weight: 'bold' },
                            color: 'black',
                        }
                    }
                },
                plugins: [window.ChartDataLabels],
            });
        }

        // 초기 차트 생성 (2023 데이터로 시작)
        let donateChart;
        createChart([140, 230, 190, 310, 280, 380, 430, 450, 330, 240, 390, 440]);

        // 셀렉트 박스의 변경 이벤트에 연도에 맞는 데이터로 차트 업데이트
        const select = document.getElementById("yearSelect");
        select.addEventListener("change", function () {
            const selectedYear = select.value;

            // 선택된 연도에 따라 더미 데이터 생성 => 수정해야함
            let dummyData;
            if (selectedYear === "2020") {
                dummyData = [100, 200, 150, 300, 250, 350, 400, 450, 300, 200, 350, 400];
            } else if (selectedYear === "2021") {
                dummyData = [120, 210, 180, 280, 260, 360, 410, 430, 320, 210, 370, 420];
            } else if (selectedYear === "2022") {
                dummyData = [130, 220, 170, 290, 270, 370, 420, 440, 310, 230, 380, 430];
            } else if (selectedYear === "2023") {
                dummyData = [196, 230, 190, 310, 280, 380, 430, 450, 330, 240, 390, 440];
            }

            createChart(dummyData);
        });

    document.addEventListener("DOMContentLoaded", function () {
        const currentYear = new Date().getFullYear();
        const select = document.getElementById("yearSelect");

        for (let year = currentYear; year <= currentYear + 10; year++) {
            const option = document.createElement("option");
            option.value = String(year);
            option.textContent = year + "년";
            select.appendChild(option);
        }

        // 미래의 연도를 추가하는 함수
        function addFutureYears() {
            const futureYears = 10; // 미래의 연도를 몇 년까지 추가할지 설정
            const lastYear = currentYear + 10;

            for (let year = lastYear + 1; year <= lastYear + futureYears; year++) {
                const option = document.createElement("option");
                option.value = String(year);
                option.textContent = year + "년";
                select.appendChild(option);
            }
        }

        // 셀렉트 박스의 변경 이벤트를 감지하고 미래의 연도 추가 함수 호출
        select.addEventListener("change", addFutureYears);
    });
















}