let replyService = (
	function() {

    function insertReplyVO(reply, callback) {
      $.ajax({
        type: "post",
        url: "/replies/insert",
        data: JSON.stringify(reply),
        contentType: "application/json; charset=utf-8",
        success: function(result, status, xhr) {
            if (callback) {
                callback(result);
            }
        },
        error: function(xhr, status, er) {
            if (error) {
                error(er);
            }
        }
      })
    }

    function listReplyVO(param, callback, error) {
        var bno = param.bno;
        var page = param.page || 1;

        $.getJSON("/replies/pages/" + bno + "/" + page + ".json",
            function(data) {
                if (callback) {
                    callback(data);
                }
            }).fail(function(xhr, status, err) {
                if (error) {
                    error();
                }
            });
    }

    function deleteReplyVO(rno, callback, error) {
        $.ajax({
            type: 'delete',
            url: '/replies/' + rno,
            success: function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function updateReplyVO(reply, callback, error) {
        $.ajax({
            type: 'put',
            url: '/replies/' + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function(xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function selectReplyVO(rno, callback, error) {
        $.get("/replies/" + rno + ".json", function(result) {
            if (callback) {
                callback(result);
            }
        }).fail(function(xhr, status, err) {
            if (error) {
                error();
            }
        });
    }

    return {
      insertReplyVO: insertReplyVO,
      listReplyVO: listReplyVO,
      deleteReplyVO: deleteReplyVO,
      updateReplyVO: updateReplyVO,
      selectReplyVO: selectReplyVO
    };

  }
)();
