function updateDateTime() {
            var now = new Date();
            var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
            var dayName = days[now.getDay()];
            var day = now.getDate();
            var month = now.toLocaleString('default', { month: 'long' });
            var year = now.getFullYear();
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();

            var dateTimeString = dayName + ', ' + day + ' ' + month + ' ' + year + ' ' + hours + ':' + minutes + ':' + seconds;
            
            document.getElementById('datetime').innerText = dateTimeString;

            setTimeout(updateDateTime, 1000); // Update every second
        }
        
        window.onload = updateDateTime;
  
  
