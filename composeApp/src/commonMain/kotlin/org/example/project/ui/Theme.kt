package org.example.project.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// --- 1. กำหนดรหัสสี (Hex Color) ---
// สีหลัก (Primary): น้ำเงินเข้ม ดูมั่นคง น่าเชื่อถือ
val WealthBlue = Color(0xFFC27A5A)
val OnWealthBlue = Color(0xFFFFFFFF) // สีตัวหนังสือบนพื้นน้ำเงิน (สีขาว)
val WealthBlueContainer = Color(0xFFD1E4FF) // สีพื้นหลังอ่อนๆ ของน้ำเงิน
val OnWealthBlueContainer = Color(0xFF001D36) // สีตัวหนังสือบนพื้นอ่อน

// สีรอง (Secondary): สีทอง/ส้ม ดูรวยๆ สมชื่อ Wealth
val Gold = Color(0xFFB88E22)
val OnGold = Color(0xFFFFFFFF)
val GoldContainer = Color(0xFFFFE085)
val OnGoldContainer = Color(0xFF281D00)

// สีพื้นหลัง (Background)
val BackgroundLight = Color(0xFFF8F9FA) // ขาวควันบุหรี่
val SurfaceLight = Color(0xFFFFFFFF) // สีขาวสำหรับ Card

// --- 2. สร้างชุดสี (Scheme) ---

val SurfaceTopColor = Color(0xFFFFF8F3)
val SurfaceBottomColor = Color(0xFFFFF0E5)

// 2. สร้างตัวแปร Brush ไล่สีจาก "บนลงล่าง" (Vertical Gradient)
val WealthSurfaceGradient = Brush.verticalGradient(
    colors = listOf(
        SurfaceTopColor,    // 0%
        SurfaceBottomColor  // 100%
    )
)

// ชุดสีสำหรับโหมดสว่าง (Light Mode)
private val LightColorScheme = lightColorScheme(
    primary = WealthBlue,
    onPrimary = OnWealthBlue,
    primaryContainer = WealthBlueContainer,
    onPrimaryContainer = OnWealthBlueContainer,

    secondary = Color(0xFFFFF0E5),
    onSecondary = OnGold,
    secondaryContainer = GoldContainer,
    onSecondaryContainer = OnGoldContainer,

    background = BackgroundLight,
    surface = SurfaceLight,
)

// ชุดสีสำหรับโหมดมืด (Dark Mode) - ถ้ายังไม่ทำ ใช้เหมือน Light ไปก่อนได้ครับ
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFC27A5A), // สีฟ้าสว่าง (สำหรับโหมดมืด)
    onPrimary = Color(0xFF00254D),
    primaryContainer = Color(0xFF004D99),
    onPrimaryContainer = Color(0xFFD1E4FF),

    secondary = Color(0xFFFFF0E5),
    onSecondary = Color(0xFF3F2E00),

    background = Color(0xFF1A1C1E),
    surface = Color(0xFF1A1C1E),
)

// --- 3. สร้าง Theme Function ไว้ครอบแอป ---
@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(), // เช็คให้อัตโนมัติว่าเครื่องลูกค้าใช้ Dark Mode ไหม
    content: @Composable () -> Unit
) {
    // เลือกชุดสีตามโหมด
    val colors = if (useDarkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    // ส่งค่าสีเข้าไปใน MaterialTheme
    MaterialTheme(
        colorScheme = colors,
        content = {
            // ✅ 2. สร้าง Box ซ้อนไว้ชั้นล่างสุด แล้วเทสี Gradient ใส่
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = WealthSurfaceGradient)
            ) {
                // 3. วางเนื้อหาแอป (หน้าจอต่างๆ) ทับลงไป
                content()
            }
        }
    )
}