$('#homework_form').submit(function(event) {
    event.preventDefault();

    const textAreaValue = $('#textHw').val();
    const homeworkId = $('input[name="id"]').val();

    // Save homework
    $.ajax({
        url: 'saveHomework',
        type: 'POST',
        dataType: 'text',
        data: {
            id: homeworkId,
            text: textAreaValue,
            action: 'save'
        },
        success: function(result) {
            // Send homework
            $.ajax({
                url: 'sendHomework',
                type: 'POST',
                dataType: 'text',
                data: {
                    id: homeworkId,
                    text: textAreaValue,
                    action: 'send'
                },
                success: function(result) {
                    // Both requests completed successfully
                    console.log('Homework saved and sent successfully');
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    // Error sending homework
                    console.error('Error sending homework');
                }
            });
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Error saving homework
            console.error('Error saving homework');
        }
    });
});
