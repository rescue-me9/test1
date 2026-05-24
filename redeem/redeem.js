/**
 * 兑换码系统 JavaScript
 * 处理弹窗显示、隐藏和验证逻辑
 */

(function() {
    'use strict';

    // 配置
    const CONFIG = {
        verifyUrl: 'redeem/verify.php',
        dialogId: 'redeemDialog',
        inputId: 'redeemCodeInput',
        submitBtnId: 'redeemSubmitBtn',
        cancelBtnId: 'redeemCancelBtn',
        messageId: 'redeemMessage',
        loadingId: 'redeemLoading'
    };

    // 初始化
    function init() {
        const dialog = document.getElementById(CONFIG.dialogId);
        const submitBtn = document.getElementById(CONFIG.submitBtnId);
        const cancelBtn = document.getElementById(CONFIG.cancelBtnId);
        const input = document.getElementById(CONFIG.inputId);

        if (!dialog || !submitBtn || !cancelBtn) {
            console.error('兑换码弹窗元素未找到');
            return;
        }

        // 绑定事件
        submitBtn.addEventListener('click', handleSubmit);
        cancelBtn.addEventListener('click', closeDialog);
        input.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                handleSubmit();
            }
        });

        // 点击背景关闭
        dialog.addEventListener('click', function(e) {
            if (e.target === dialog) {
                closeDialog();
            }
        });
    }

    // 打开兑换码弹窗
    window.openRedeemDialog = function() {
        const dialog = document.getElementById(CONFIG.dialogId);
        const input = document.getElementById(CONFIG.inputId);
        const message = document.getElementById(CONFIG.messageId);

        if (dialog) {
            dialog.classList.add('show');
            input.focus();
            input.value = '';
            clearMessage();
        }
    };

    // 关闭兑换码弹窗
    function closeDialog() {
        const dialog = document.getElementById(CONFIG.dialogId);
        if (dialog) {
            dialog.classList.remove('show');
        }
    }

    // 处理提交
    function handleSubmit() {
        const input = document.getElementById(CONFIG.inputId);
        const code = input.value.trim();

        if (!code) {
            showMessage('请输入兑换码', 'error');
            return;
        }

        submitCode(code);
    }

    // 提交兑换码到后端
    function submitCode(code) {
        const submitBtn = document.getElementById(CONFIG.submitBtnId);
        const loading = document.getElementById(CONFIG.loadingId);

        // 禁用按钮并显示加载状态
        submitBtn.disabled = true;
        loading.classList.add('show');

        const formData = new FormData();
        formData.append('code', code);
        formData.append('action', 'verify');

        fetch(CONFIG.verifyUrl, {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            loading.classList.remove('show');
            submitBtn.disabled = false;

            if (data.success) {
                showMessage(data.message, 'success');
                document.getElementById(CONFIG.inputId).value = '';
                // 2秒后关闭弹窗
                setTimeout(closeDialog, 2000);
            } else {
                showMessage(data.message, 'error');
            }
        })
        .catch(error => {
            console.error('请求失败:', error);
            loading.classList.remove('show');
            submitBtn.disabled = false;
            showMessage('网络错误，请稍后重试', 'error');
        });
    }

    // 显示消息
    function showMessage(message, type) {
        const messageEl = document.getElementById(CONFIG.messageId);
        if (messageEl) {
            messageEl.textContent = message;
            messageEl.className = `redeem_message show ${type}`;
        }
    }

    // 清除消息
    function clearMessage() {
        const messageEl = document.getElementById(CONFIG.messageId);
        if (messageEl) {
            messageEl.className = 'redeem_message';
            messageEl.textContent = '';
        }
    }

    // 页面加载完成后初始化
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', init);
    } else {
        init();
    }
})();