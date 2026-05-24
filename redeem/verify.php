<?php
/**
 * 兑换码验证系统
 * 支持单次使用，验证成功后自动删除
 */

// 设置响应头
header('Content-Type: application/json; charset=utf-8');
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: POST, GET, OPTIONS');

// 获取请求参数
$code = isset($_POST['code']) ? trim($_POST['code']) : '';
$action = isset($_POST['action']) ? trim($_POST['action']) : 'verify';

// 兑换码文件路径
$codesFile = __DIR__ . '/codes.txt';

// 验证文件是否存在
if (!file_exists($codesFile)) {
    http_response_code(500);
    echo json_encode([
        'success' => false,
        'message' => '系统配置错误'
    ]);
    exit;
}

if ($action === 'verify') {
    if (empty($code)) {
        echo json_encode([
            'success' => false,
            'message' => '请输入兑换码'
        ]);
        exit;
    }

    // 读取所有兑换码
    $codes = file($codesFile, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    $codeFound = false;
    $newCodes = [];

    foreach ($codes as $line) {
        $trimmedCode = trim($line);
        if ($trimmedCode === $code) {
            $codeFound = true;
            // 跳过这行（删除兑换码）
            continue;
        }
        $newCodes[] = $trimmedCode;
    }

    if ($codeFound) {
        // 将更新后的兑换码写回文件
        if (file_put_contents($codesFile, implode("\n", $newCodes) . "\n")) {
            echo json_encode([
                'success' => true,
                'message' => '兑换成功！',
                'code' => $code
            ]);
        } else {
            http_response_code(500);
            echo json_encode([
                'success' => false,
                'message' => '系统错误，请稍后重试'
            ]);
        }
    } else {
        echo json_encode([
            'success' => false,
            'message' => '兑换码错误或已被使用'
        ]);
    }
} else {
    http_response_code(400);
    echo json_encode([
        'success' => false,
        'message' => '无效的操作'
    ]);
}
?>
