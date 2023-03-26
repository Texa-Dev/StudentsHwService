$(document).ready(function() {
    $('#updateUserSub').click(function(e) {
        e.preventDefault();

        const role = $('#role').val();
        const status = $('#status').val();
        console.log(role)
        console.log(status)

        $.ajax({
            type: 'POST',
            url: '/userUpdate',
            data: {
                id: $('#user-id').val(),
                userRole: role,
                userStatus: status
            },
            success: function(response) {
                console.log(response);
            },
            error: function(xhr, status, error) {
                console.log(error);
            }
        });
    });
});